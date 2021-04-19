package com.ehsankolivand.constants

import java.lang.AssertionError

/*
* Copyright (C) 2020 Adrian Miozga <AdrianMiozga@outlook.com>
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/
class Constants private constructor() {
    companion object {
        // SharedPreferences Keys
        const val HISTORY_SPINNER_SETTING = "history_spinner_setting"
        const val ACTIVITIES_SPINNER_SETTING = "activities_spinner_setting"
        const val APPLICATION_LOCK_PREFERENCE = "application_lock_preference"
        const val LOCKED_APPLICATIONS_LIST = "locked_applications_list"
        const val MASTER_LOCK_APPLICATION_SETTING = "master_lock_application_setting"
        const val CURRENT_ACTIVITY_ID = "current_activity_id"
        const val KEEP_SCREEN_ON_SETTING = "keep_screen_on"
        const val IS_STOP_BUTTON_VISIBLE = "is_stop_button_visible"
        const val IS_SKIP_BUTTON_VISIBLE = "is_skip_button_visible"
        const val IS_START_BUTTON_VISIBLE = "is_start_button_visible"
        const val IS_PAUSE_BUTTON_VISIBLE = "is_pause_button_visible"
        const val IS_WORK_ICON_VISIBLE = "is_work_icon_visible"
        const val IS_BREAK_ICON_VISIBLE = "is_break_icon_visible"
        const val IS_TIMER_BLINKING = "is_timer_blinking"
        const val TUTORIAL_STEP = "tutorial_step"
        const val AUTOMATICALLY_START_NEW_ACTIVITIES = "automatically_start_activities"
        const val SCROLL_PIE_CHART_AUTOMATICALLY = "scroll_pie_chart_automatically"
        const val FULL_SCREEN_MODE = "full_screen_mode"
        const val NEVER_SHOW_IGNORE_BATTERY_OPTIMIZATION_DIALOG =
            "never_show_ignore_battery_optimization_dialog"


        const val WORK_SESSION_COUNTER = "work_session_counter"
        /**
         * It's a work duration value taken from activity settings when starting a timer.
         */
        const val LAST_SESSION_DURATION = "last_session_duration"

        /** It's zero when the timer is stopped or between work/break, break/work timers.  */
        const val TIME_LEFT = "time_left"
        const val IS_TIMER_RUNNING = "is_timer_running"
        const val IS_BREAK_STATE = "is_break_state"
        const val CENTER_BUTTONS = "center_buttons"

        /** Either complete or incomplete.  */
        const val TIMESTAMP_OF_LAST_WORK_SESSION = "timestamp_of_last_work_session"

        // Defaults
        const val DEFAULT_WORK_TIME = 25
        const val DEFAULT_BREAK_TIME = 5
        const val DEFAULT_SESSIONS_BEFORE_LONG_BREAK = 4
        const val DEFAULT_LONG_BREAK_TIME = 20
        const val sourceCodeURL = "https://github.com/AdrianMiozga/GetFlow"
        const val feedbackURL = "mailto:AdrianMiozga@outlook.com?subject=Feedback about %s"

        /** Over this time the user has to build work sessions again for long break.  */
        const val HOURS_BEFORE_WORK_SESSION_COUNT_RESETS = 1

        /** Minimum time to save session to database.  */
        const val MINIMUM_SESSION_TIME = 30000

        /** Frequency of vibration when the timer is waiting for action - after it ends.  */
        const val VIBRATION_REMINDER_FREQUENCY: Long = 30000
        const val MAX_ACTIVITY_NAME_LENGTH = 50

        /** Modifies the length of animation when toggling between GONE and VISIBLE on certain View in app settings.  */
        const val DEFAULT_ANIMATION_LENGTH = 250

        // Database
        const val DATABASE_NAME = "GetFlow.db"

        // TimerNotification Ids
        const val TIME_LEFT_NOTIFICATION = 1
        const val ON_FINISH_NOTIFICATION = 2

        // Pending Intent Request Codes
        const val PENDING_INTENT_OPEN_APP_REQUEST_CODE = 0
        const val PENDING_INTENT_SKIP_REQUEST_CODE = 1
        const val PENDING_INTENT_PAUSE_RESUME_REQUEST_CODE = 2
        const val PENDING_INTENT_STOP_REQUEST_CODE = 3
        const val PENDING_INTENT_END_REQUEST_CODE = 4

        // Intent Filters
        const val UPDATE_UI = "button_clicked"
        const val ON_TICK = "on_tick"

        // Intent Action
        const val BUTTON_ACTION = "button_action"
        const val UPDATE_UI_ACTION = "update_ui_action"

        // Intent Extra
        const val BUTTON_STOP = "button_stop"
        const val BUTTON_SKIP = "button_skip"
        const val BUTTON_START = "button_start"
        const val BUTTON_PAUSE = "button_pause"
        const val TIME_LEFT_INTENT = "time_left_intent"
        const val ACTIVITY_NAME = "activity_name"
        const val ACTIVITY_ID_INTENT = "activity_id"
        const val WORK_DURATION_INTENT = "work_duration_intent"
        const val BREAK_DURATION_INTENT = "break_duration_intent"
        const val ARE_LONG_BREAKS_ENABLED_INTENT = "are_long_breaks_enabled_intent"
        const val SESSIONS_BEFORE_LONG_BREAK_INTENT = "sessions_before_long_break_intent"
        const val LONG_BREAK_DURATION_INTENT = "long_break_duration_intent"
        const val CURRENT_ACTIVITY_ID_INTENT = "current_activity_id_intent"

        // TimerNotification Channels
        const val CHANNEL_TIMER = "Pomodoro Timer"
        const val CHANNEL_TIMER_COMPLETED = "Pomodoro Timer Completed"

        // Services
        const val NOTIFICATION_SERVICE = "notification_service"
        const val NOTIFICATION_SERVICE_PAUSE = "notification_service_pause"

        // Wake Lock
        const val WAKE_LOCK_TAG = "pomodoro::wake_lock"
        // Activity Pie Chart
        /** Display percentages on activity pie chart from this value (inclusive).  */
        const val DISPLAY_PERCENTAGES_FROM = 9

        /** Any activity on the pie chart below this percent will be clumped into Others.  */
        const val CLUMP_ACTIVITIES_BELOW_THIS_PERCENT = 9

        /**
         * Max activities to show on activity chart. This also includes the special "Others" activity. If there is more
         * activities they will be put under Others and shown in the legend.
         */
        const val MAX_ITEMS_TO_SHOW_ON_ACTIVITY_CHART = 6
    }

    // Suppress default constructor for noninstantiability
    init {
        throw AssertionError()
    }
}