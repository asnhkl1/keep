package com.lee.keep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** KeepPlugin */
public class KeepPlugin implements MethodCallHandler {
  private Activity activity;
  private Context context;
  public KeepPlugin(Activity activity, Context context) {
    this.activity = activity;
    this.context = context;
  }

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "keep");
    channel.setMethodCallHandler(new KeepPlugin(registrar.activity(),registrar.context()));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("keepAlive")) {
      activity.startService(new Intent(context, LocalService.class));
      activity.startService(new Intent(context, RemoteService.class));
      MyJobService.startJob(activity);
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else {
      result.notImplemented();
    }
  }


}
