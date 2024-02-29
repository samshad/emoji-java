package com.vdurmont.emoji;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import static junit.framework.TestCase.assertNotSame;

@RunWith(JUnit4.class)

public class NewEmojiParserTest {
    @Test
    public void testParserWithTwoEmojisButGettingForFour() {
        String input = "I'm 👨🏽‍🔬 and she's 👩🏻‍💻";
        List<String> emojis = EmojiParser.extractEmojis(input);
        assertNotSame("Expected 2 but given 4", 2, emojis.size());
    }
}
