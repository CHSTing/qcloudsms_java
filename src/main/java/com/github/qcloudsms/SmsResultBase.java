package com.github.qcloudsms;

import org.json.JSONObject;
import org.json.JSONException;

import com.github.qcloudsms.httpclient.HTTPResponse;


/**
 * Sms result base class
 *
 * @since 1.0.0
 */
public abstract class SmsResultBase {

    protected HTTPResponse response;

    /**
     * Parse result from HTTPResponse instance
     *
     * @param response  HTTP response from api return
     * @return SmsResultbase
     * @throws JSONException
     */
    public abstract SmsResultBase parseFromHTTPResponse(HTTPResponse response)
        throws JSONException;

    /**
     * Parse HTTP response to json
     *
     * @param response  HTTP response
     * @return JSONObject
     * @throws JSONException
     */
    public JSONObject parseToJson(HTTPResponse response) throws JSONException {
        // Set raw response
        this.response = response;
        // May throw JSONException
        return new JSONObject(response.body);
    }

    /**
     * Get raw response
     *
     * @return HTTPResponse
     */
    public HTTPResponse getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return response.body;
    }
}
