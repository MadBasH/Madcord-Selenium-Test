package com.madcord.tests.channels;

import com.madcord.base.BaseTest;
import com.madcord.pages.ChannelsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ChannelTests extends BaseTest {

    @Test
    public void testChannelsWelcomeIsDisplayed() {
        ChannelsPage channelsPage = new ChannelsPage();
        assertTrue(channelsPage.isWelcomeToChatDisplayed(),
                "\n Chat Welcome is not displayed \n");
    }

    @Test
    public void testChannelsIsClickedChannelOpened() {
        ChannelsPage channelsPage = new ChannelsPage();
        String channelName = "test-server";
        channelsPage.clickSelectedChannel(channelName);
        String actualText = channelsPage.clickedChannelOpened();
        assertTrue(actualText.contains(channelName));
    }

    @Test
    public void testChannelsCreateChannel() {
        ChannelsPage channelsPage = new ChannelsPage();
        channelsPage.clickCreateChannelButton();
        String channelName = "created-audio-channel";
        channelsPage.setCreateChannelName(channelName);
        channelsPage.clickCreateChannelTypeButton();
        channelsPage.selectChannelTypeButton("audio");
        channelsPage.clickCreateButton();
        assertTrue(channelsPage.isChannelCreated(channelName),
                "Channel Create is not successful");
    }

    @Test
    public void testChannelsEditChannel() {
        ChannelsPage channelsPage = new ChannelsPage();
        String channelName = "new-channel";
        String changedChannelName = "changed-channel-name";
        channelsPage.clickSelectedChannel(channelName);
        channelsPage.clickEditChannelButton();
        channelsPage.setCreateChannelName(changedChannelName);
        channelsPage.selectChannelTypeButton("video");
        channelsPage.clickCreateButton();
        assertTrue(channelsPage.isChannelCreated(changedChannelName),
                "Channel Edit is not successful");
        assertTrue(channelsPage.isVideoChannelCreated(),
                "Channel Edit is not successful");
    }

    @Test
    public void testChannelsDeleteChannel() {
        ChannelsPage channelsPage = new ChannelsPage();
        String channelName = "dummy-channel";
        channelsPage.clickSelectedChannel(channelName);
        channelsPage.clickDeleteChannelIcon();
        channelsPage.clickDeleteChannelButton();
        assertTrue(channelsPage.isChannelDeleted(channelName),
                "Channel Delete is not successful");
    }

}
