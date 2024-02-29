package com.vdurmont.emoji;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class NewEmojiManagerTest {

    //Proving following emoji is not into the repo
    @Test
    public void EmojiManagerTest_with_depicts_a_person_swimming() {
        String depicts_a_person_swimming = "\uD83C\uDFCA\u200D♂\uFE0F"; //🏊‍♂️
        boolean isItEmoji = EmojiManager.isEmoji(depicts_a_person_swimming);
        assertFalse(isItEmoji);
    }

    @Test
    public void EmojiManagerTest_with_woman_rowing_boat() {
        String woman_rowing_boat = "\uD83D\uDEA3\u200D♀\uFE0F"; //🚣‍♀️
        boolean isItEmoji = EmojiManager.isEmoji(woman_rowing_boat);
        assertFalse(isItEmoji);
    }


    @Test
    public void EmojiManagerTest_with_skier() {
        String Skier = "⛷\uFE0F";//⛷️
        boolean isItEmoji = EmojiManager.isEmoji(Skier);
        assertFalse(isItEmoji);
    }
}
