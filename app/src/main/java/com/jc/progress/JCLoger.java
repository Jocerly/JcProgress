/*
 * Copyright (c) 2014,JCFrameForAndroid Open Source Project,Jocerly.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jc.progress;

import android.util.Log;

/**
 * 应用程序的Log管理<br>
 * <b>创建时间</b> 2014-2-28
 * 
 * @author Jocerly
 * @version 1.1
 */
public final class JCLoger {
    public static boolean IS_DEBUG = BuildConfig.DEBUG;
    public static String DEBUG = "JCLoger";
    
    public static final void openDebugLog(boolean enable) {
        IS_DEBUG = enable;
    }

    public static final void debug(String msg) {
        if (IS_DEBUG) {
            Log.i(DEBUG, msg);
        }
    }

    public static final void log(String packName, String state) {
        debugLog(packName, state);
    }

    public static final void debug(String msg, Throwable tr) {
        if (IS_DEBUG) {
            Log.i(DEBUG, msg, tr);
        }
    }

    public static final void state(String packName, String state) {
        if (IS_DEBUG) {
            Log.d(DEBUG, packName + state);
        }
    }

    public static final void debugLog(String packName, String state) {
        if (IS_DEBUG) {
            Log.d(DEBUG, packName + state);
        }
    }

    public static final void exception(Exception e) {
        if (IS_DEBUG) {
            e.printStackTrace();
        }
    }

    public static final void debug(String msg, Object... format) {
        debug(String.format(msg, format));
    }
}
