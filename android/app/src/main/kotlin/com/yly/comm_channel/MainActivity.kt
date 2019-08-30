package com.yly.comm_channel

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast

import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.*
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity : FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegistrant.registerWith(this)

        //*******************  BasicMessageChannel******************

//        val basicMessageChannel = BasicMessageChannel<String>(
//                flutterView,
//                "basicMessageChannel",
//                StringCodec.INSTANCE)

//
//        basicMessageChannel.setMessageHandler { message, reply ->
//            println("native  $message")
//            reply.reply("native reply")
//        }

        //        Handler(Looper.getMainLooper()).postDelayed({
//            basicMessageChannel.send("from native") {
//                println(it)
//            }
//        }, 5000)

        //*******************  MethodChannel******************

//        val methodChannel = MethodChannel(
//                flutterView,
//                "methodChannel")
//
//        methodChannel.setMethodCallHandler { name, result ->
//            println("dart call name   $name")
//            result.success("native method success")
//        }
//
//        Handler(Looper.getMainLooper()).postDelayed({
//            methodChannel.invokeMethod("testMethod", null, object : MethodChannel.Result {
//                override fun notImplemented() {
//                }
//
//                override fun error(p0: String?, p1: String?, p2: Any?) {
//                }
//
//                override fun success(p0: Any?) {
//                    println("native call success   $p0")
//                }
//            })
//        }, 5000)

        //*******************  EventChannel******************

        val eventChannel = EventChannel(flutterView, "eventChannel")

        eventChannel.setStreamHandler(object : EventChannel.StreamHandler {
            override fun onListen(p0: Any?, p1: EventChannel.EventSink?) {
                println("event $p0")
                p1?.success("event success")
            }

            override fun onCancel(p0: Any?) {
            }

        })
    }
}
