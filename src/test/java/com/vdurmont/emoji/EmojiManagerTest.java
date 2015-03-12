package com.vdurmont.emoji;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class EmojiManagerTest {
    @Test
    public void getForTag_with_unknown_tag_returns_null() throws IOException {
        // GIVEN

        // WHEN
        Set<Emoji> emojis = EmojiManager.getForTag("jkahsgdfjksghfjkshf");

        // THEN
        assertNull(emojis);
    }

    @Test
    public void getForTag_returns_the_emojis_for_the_tag() throws IOException {
        // GIVEN

        // WHEN
        Set<Emoji> emojis = EmojiManager.getForTag("happy");

        // THEN
        assertEquals(4, emojis.size());
        assertTrue(TestTools.containsEmojis(emojis, "smile", "smiley", "grinning", "satisfied"));
    }

    @Test
    public void getForAlias_with_unknown_alias_returns_null() throws IOException {
        // GIVEN

        // WHEN
        Emoji emoji = EmojiManager.getForAlias("jkahsgdfjksghfjkshf");

        // THEN
        assertNull(emoji);
    }

    @Test
    public void getForAlias_returns_the_emoji_for_the_alias() throws IOException {
        // GIVEN

        // WHEN
        Emoji emoji = EmojiManager.getForAlias("smile");

        // THEN
        assertEquals("smiling face with open mouth and smiling eyes", emoji.getDescription());
    }

    @Test
    public void getForAlias_with_colons_returns_the_emoji_for_the_alias() throws IOException {
        // GIVEN

        // WHEN
        Emoji emoji = EmojiManager.getForAlias(":smile:");

        // THEN
        assertEquals("smiling face with open mouth and smiling eyes", emoji.getDescription());
    }

    @Test
    public void isEmoji_for_an_emoji_returns_true() {
        // GIVEN
        String emoji = "😀";

        // WHEN
        boolean isEmoji = EmojiManager.isEmoji(emoji);

        // THEN
        assertTrue(isEmoji);
    }

    @Test
    public void isEmoji_for_a_non_emoji_returns_false() {
        // GIVEN
        String str = "test";

        // WHEN
        boolean isEmoji = EmojiManager.isEmoji(str);

        // THEN
        assertFalse(isEmoji);
    }

    @Test
    public void isEmoji_for_an_emoji_and_other_chars_returns_false() {
        // GIVEN
        String str = "😀 test";

        // WHEN
        boolean isEmoji = EmojiManager.isEmoji(str);

        // THEN
        assertFalse(isEmoji);
    }

    @Test
    public void getAllTags_returns_the_tags() {
        // GIVEN

        // WHEN
        Collection<String> tags = EmojiManager.getAllTags();

        // THEN
        // We know the database has 364 distinct tags...!
        assertEquals(364, tags.size());
    }
}