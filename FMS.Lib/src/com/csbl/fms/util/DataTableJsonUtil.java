package com.csbl.fms.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DataTableJsonUtil {
    
    public String getDataGridJSON(DataTableParamModel param, long iTotalRecords, long iTotalDisplayRecords, JsonElement element)
    {
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("sEcho", param.sEcho);
        jsonResponse.addProperty("iTotalRecords", iTotalRecords);
        jsonResponse.addProperty("iTotalDisplayRecords", iTotalDisplayRecords);
        jsonResponse.add("aaData", element);
        return jsonResponse.toString();
    }
    
}
