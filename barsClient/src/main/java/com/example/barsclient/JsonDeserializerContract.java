package com.example.barsclient;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.google.gson.*;

public class JsonDeserializerContract implements JsonDeserializer<Contract>{

    private Date parseDate(JsonObject contractJson, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            date = sdf.parse(contractJson.get(value).getAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public Contract deserialize(JsonElement json, Type type,
                                JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject contractJson = json.getAsJsonObject();
        long id = contractJson.get("id").getAsLong();
        Date created = parseDate(contractJson, "created");
        Date updated = parseDate(contractJson, "updated");


        Contract contract = new Contract();
        contract.setId(id);
        contract.setCreated(created);
        contract.setUpdated(updated);

        return contract;
    }
}
