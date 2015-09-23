package pl.util.provider;

import com.google.gson.FieldAttributes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface GsonExclude {

    public class ExclusionStrategy implements com.google.gson.ExclusionStrategy {

        public ExclusionStrategy() {
        }

        public boolean shouldSkipClass(Class<?> clazz) {
            return clazz.getAnnotation(GsonExclude.class) != null;
        }

        public boolean shouldSkipField(FieldAttributes f) {
            return f.getAnnotation(GsonExclude.class) != null;
        }
    }
}