package com.ehsankolivand.constants.database

enum class PriorityColorEnum(hex: Long): IPriorityColor {

    BLACK(0xFF000000){
        override fun getHexCode(): Long
        {
            return 0xFF000000
        }
    },
    GRAY(0xFF673AB7)
    {
        override fun getHexCode(): Long
        {
            return 0xFF673AB7
        }
    },
    SILVER(0xFFC7C6CC)
    {
        override fun getHexCode(): Long
        {
            return 0xFFC7C6CC
        }
    },
    LightBlue(0xFF007AFF)
    {
        override fun getHexCode(): Long
        {
            return 0xFF007AFF
        }
    },
    GREEN(0xFF35C75A)
    {
        override fun getHexCode(): Long
        {
            return 0xFF35C75A
        }
    },
    BLUE(0xFF5756D6)
    {
        override fun getHexCode(): Long
        {
            return 0xFF5756D6
        }
    },
    PINK(0xFFAF50DE)
    {
        override fun getHexCode(): Long
        {
            return 0xFFAF50DE
        }
    },
    LightRed(0xFFFF2B54)
    {
        override fun getHexCode(): Long
        {
            return 0xFFFF2B54
        }
    },
    Red(0xFFFE3C30){
        override fun getHexCode(): Long
        {
            return 0xFFFE3C30
        }
    },
    Orange(0xFFFE9400){
        override fun getHexCode(): Long
        {
            return 0xFFFE9400
        }
    },
    LightOrange(0xFFFFCC01)
    {
        override fun getHexCode(): Long
        {
            return 0xFFFFCC01

        }
    },
    DarkOrange(0xFFDAAF05)
    {
        override fun getHexCode(): Long
        {
            return 0xFFDAAF05

        }
    }
}