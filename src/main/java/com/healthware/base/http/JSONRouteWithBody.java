package com.healthware.base.http;

import com.healthware.Utilities;

public abstract class JSONRouteWithBody<T> extends RouteWithJSONBody<T> {
    protected JSONRouteWithBody(Class<T> bodyType) {
        super(bodyType);
    }

    protected abstract HTTPResponse getObject(T body, HTTPRequest request) throws Exception;

    @Override
    protected HTTPResponse<String> getResponse(T body, HTTPRequest request) throws Exception {
        HTTPResponse response = getObject(body, request);
        return new HTTPResponse<>(response.status, Utilities.serializeJSON(response.content), "application/json");
    }
}
