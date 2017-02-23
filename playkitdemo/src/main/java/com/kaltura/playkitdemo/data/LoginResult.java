package com.kaltura.playkitdemo.data;

import com.kaltura.playkit.backend.BaseResult;

/**
 * @hide
 */

public class LoginResult extends BaseResult{

    Result result;

    public String getKs(){
        return result != null ? result.getKs() : null;
    }

    class Result{
        LoginSession loginSession;

        public String getKs(){
            return loginSession != null ? loginSession.ks : null;
        }
    }

    class LoginSession{
        String ks;
    }
}
