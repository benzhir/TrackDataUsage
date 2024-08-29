/*
 * Copyright (C) 2021 Dr.NooB
 *
 * This file is a part of Data Monitor <https://github.com/itsdrnoob/DataMonitor>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.hc2i.datamonitor.ui.fragments

import android.content.Intent
import android.os.Bundle
import com.hc2i.datamonitor.core.base.Preference
import androidx.preference.PreferenceFragmentCompat
import com.hc2i.datamonitor.R
import com.hc2i.datamonitor.core.Values.*
import com.hc2i.datamonitor.ui.activities.ContainerActivity
import com.hc2i.datamonitor.ui.activities.WallOfThanksActivity

class ContributorsFragment: PreferenceFragmentCompat() {
    private lateinit var appContributors: Preference
    private lateinit var wallOfThanks: Preference
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.contributors_preference, rootKey)

        appContributors = findPreference("app_contributors")!!
        wallOfThanks = findPreference("wall_of_thanks")!!

        appContributors.setOnPreferenceClickListener {
            context?.startActivity(Intent(context, ContainerActivity().javaClass)
                .putExtra(GENERAL_FRAGMENT_ID, APP_CONTRIBUTORS_FRAGMENT))
            false
        }

        wallOfThanks.setOnPreferenceClickListener {
            context?.startActivity(Intent(context, WallOfThanksActivity().javaClass))
            false
        }

    }
}