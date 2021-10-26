package com.ehsankolivand.constants


fun Int.getEmojiByUnicode(): String? {
    return String(Character.toChars(this))
}