# Modelos deserializados con Gson
-keep class com.minuevaapp.tv.data.** { *; }
-keepattributes Signature, *Annotation*
-keep,allowobfuscation,allowshrinking interface retrofit2.Call
-keep,allowobfuscation,allowshrinking class retrofit2.Response
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

# Gson: conservar firmas genericas y clases de persistencia (R8 full mode)
-keep class com.google.gson.reflect.TypeToken { *; }
-keep class * extends com.google.gson.reflect.TypeToken
-keepclassmembers,allowobfuscation class * { @com.google.gson.annotations.SerializedName <fields>; }
-keep class com.minuevaapp.tv.data.Playlist { *; }
-keep class com.minuevaapp.tv.data.PlaybackProgress { *; }
-keep class com.minuevaapp.tv.data.PlaybackProgressEntry { *; }
