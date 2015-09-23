package pl.util.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class JerseyGsonReader implements MessageBodyReader<Object> {

    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    public static Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .setPrettyPrinting()
            .setExclusionStrategies(new GsonExclude.ExclusionStrategy())
            .create();


    @Override
    public Object readFrom(Class<Object> objectClass, Type type, Annotation[] annotations,
                           MediaType mediaType, MultivaluedMap<String, String> stringStringMultivaluedMap,
                           InputStream inputStream) throws IOException, WebApplicationException {
        return GSON.fromJson(new InputStreamReader(inputStream, Charset.forName("UTF-8")), type);
    }
}