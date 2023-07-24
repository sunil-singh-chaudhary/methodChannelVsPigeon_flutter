// Autogenerated from Pigeon (v10.1.4), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package io.flutter.plugins;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression", "serial"})
public class batteryinfoApi {

  /** Error class for passing custom error details to Flutter via a thrown PlatformException. */
  public static class FlutterError extends RuntimeException {

    /** The error code. */
    public final String code;

    /** The error details. Must be a datatype supported by the api codec. */
    public final Object details;

    public FlutterError(@NonNull String code, @Nullable String message, @Nullable Object details) 
    {
      super(message);
      this.code = code;
      this.details = details;
    }
  }

  @NonNull
  protected static ArrayList<Object> wrapError(@NonNull Throwable exception) {
    ArrayList<Object> errorList = new ArrayList<Object>(3);
    if (exception instanceof FlutterError) {
      FlutterError error = (FlutterError) exception;
      errorList.add(error.code);
      errorList.add(error.getMessage());
      errorList.add(error.details);
    } else {
      errorList.add(exception.toString());
      errorList.add(exception.getClass().getSimpleName());
      errorList.add(
        "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }
    return errorList;
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class BatteryInfo {
    private @Nullable String batteryPercentage;

    public @Nullable String getBatteryPercentage() {
      return batteryPercentage;
    }

    public void setBatteryPercentage(@Nullable String setterArg) {
      this.batteryPercentage = setterArg;
    }

    public static final class Builder {

      private @Nullable String batteryPercentage;

      public @NonNull Builder setBatteryPercentage(@Nullable String setterArg) {
        this.batteryPercentage = setterArg;
        return this;
      }

      public @NonNull BatteryInfo build() {
        BatteryInfo pigeonReturn = new BatteryInfo();
        pigeonReturn.setBatteryPercentage(batteryPercentage);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<Object>(1);
      toListResult.add(batteryPercentage);
      return toListResult;
    }

    static @NonNull BatteryInfo fromList(@NonNull ArrayList<Object> list) {
      BatteryInfo pigeonResult = new BatteryInfo();
      Object batteryPercentage = list.get(0);
      pigeonResult.setBatteryPercentage((String) batteryPercentage);
      return pigeonResult;
    }
  }

  private static class BatteryInfoApiCodec extends StandardMessageCodec {
    public static final BatteryInfoApiCodec INSTANCE = new BatteryInfoApiCodec();

    private BatteryInfoApiCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 128:
          return BatteryInfo.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof BatteryInfo) {
        stream.write(128);
        writeValue(stream, ((BatteryInfo) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface BatteryInfoApi {
    /**
     * This abstract function will contain code that performs communication
     * with native platforms, sending in [FileData] as a message and receiving [Response] as a response.
     */
    @NonNull 
    BatteryInfo getbatteryInformation();

    /** The codec used by BatteryInfoApi. */
    static @NonNull MessageCodec<Object> getCodec() {
      return BatteryInfoApiCodec.INSTANCE;
    }
    /**Sets up an instance of `BatteryInfoApi` to handle messages through the `binaryMessenger`. */
    static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable BatteryInfoApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.methodchanneldemo_sample1.BatteryInfoApi.getbatteryInformation", getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<Object>();
                try {
                  BatteryInfo output = api.getbatteryInformation();
                  wrapped.add(0, output);
                }
 catch (Throwable exception) {
                  ArrayList<Object> wrappedError = wrapError(exception);
                  wrapped = wrappedError;
                }
                reply.reply(wrapped);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
}