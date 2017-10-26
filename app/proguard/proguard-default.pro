#代码混淆压缩比，在0~7之间，默认为5，一般不做修改
-optimizationpasses 5

#混合时不使用大小写混合，混合后的类名为小写
-dontusemixedcaseclassnames

#指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses

#这句话能够使我们的项目混淆后产生映射文件
#包含有类名->混淆后类名的映射关系
-verbose

#指定不去忽略非公共库的类
-dontskipnonpubliclibraryclassmembers

#不做预校验，preverify是proguard的四个步骤之一，Android不需要preverify，去掉这一步能够加快混淆速度。
-dontpreverify

#保留Annotation不混淆
-keepattributes *Annotation*,InnerClasses

#避免混淆泛型
-keepattributes Signature
-keepattributes EnclosingMethod

#抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable

#未混淆的类和成员
-printseeds seeds.txt
#列出从 apk 中删除的代码
-printusage unused.txt
#混淆前后的映射
-printmapping mapping.txt

#指定混淆是采用的算法，后面的参数是一个过滤器
#这个过滤器是谷歌推荐的算法，一般不做更改
-optimizations !code/simplification/cast,!field/*,!class/merging/*

#保留我们使用的四大组件，自定义的Application等等这些类不被混淆
#因为这些子类都有可能被外部调用
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Appliction
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService

#保留support下的所有类及其内部类
-keep class android.support.** {*;}

#保留R下面的资源
-keep class **.R$* {*;}

#保留本地native方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

#保留在Activity中的方法参数是view的方法，
#这样以来我们在layout中写的onClick就不会被影响
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}

#保留枚举类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#保留我们自定义控件（继承自View）不被混淆
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

#保留Parcelable序列化类不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#保留Serializable序列化的类不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# js交互
-dontwarn com.hna.hi.webview.**
-keep class com.hna.hi.webview.action.** { *; }

# 保留 第三方依赖

-keep class com.alipay.** {*;}
-dontwarn com.alipay.**

-keep class com.ta.utdid2.**{*;}
-dontwarn com.ta.utdid2.**

-keep class com.ut.device.**{*;}
-dontwarn com.ut.device.**

-keep class org.json.alipay.** {*;}
-dontwarn org.json.alipay.**

-keep class com.rey.material.** { *; }
-dontwarn com.rey.material.**

-keep class com.zxinsight.** { *; }
-dontwarn com.zxinsight.**

-dontnote com.andexert.**
-dontnote com.hna.hi.common.customview.Switch

-keep class com.makeramen.**{*;}
-dontwarn com.squareup.**
-keep class com.squareup.** { *;}

-keep class com.aurelhubert.ahbottomnavigation.**{*;}
-keep class com.bigkoo.convenientbanner.**{*;}

-keep class com.hna.hi.common.customview.**{*;}
-keep class com.hna.hi.common.customview.glide.**{*;}

-keep class com.hna.hi.common.fragment.ToastDialogFragment$IToastCallBack
-keep class com.hna.hi.common.fragment.TipDialogFragment$ITip
-keep class com.hna.hi.common.fragment.DeleteDialogDialogFragment$IDelete
-keep class com.hna.hi.common.fragment.ToastDialogFragment$IToastCallBack
-keep class com.hna.hi.hnahelper.modules.emoji.model.EmojiModel
-keep class com.hna.hi.common.view.datepicker.wheel.AbstractWheelTextAdapter
-keep class com.hna.hi.common.view.datepicker.wheel.WheelViewAdapter
-keep class com.hna.hi.common.view.pulldown.IHeaderState
-keep class com.hna.hi.view.home.model.DiscoverVPModel
-keep class com.hna.hi.db.converter.SexType
-keep class com.tencent.tauth.IUiListener
-keep class com.hna.hi.view.my.model.PhotoImage
-keep class com.tencent.tauth.Tencent

-dontwarn com.jude.**
-keep class com.jude.**{*;}

-dontwarn com.hna.hi.common.view.widget.wheel.**
-keep class com.hna.hi.common.view.widget.wheel.**{*;}




#uk.co.senab.photoview.PhotoView
-keep class uk.co.senab.photoview.**{*;}

#zip
-dontwarn org.slf4j.**

-keep class org.zeroturnaround.zip.**{*;}
-keep class com.twotoasters.jazzylistview.**{*;}
-keep class com.airbnb.lottie.**{*;}

#google
-dontwarn com.google.common.base.**
-keep class com.google.common.base.** {*;}
-dontwarn com.google.errorprone.annotations.**
-keep class com.google.errorprone.annotations.** {*;}

-keep class com.hna.hi.hnahelper.modules.thirdpart.media.view.SimpleExoPlayerView{*;}
-dontwarn org.zeroturnaround.zip.**

-dontnote com.hna.hi.webview.**
-dontnote com.growingio.android.**
-dontnote com.tencent.connect.**
-dontnote com.hna.hi.display.IDialogDisplay
-dontnote me.gujun.android.**
-dontnote in.srain.cube.views.**
-dontnote com.tencent.open.**
-dontnote com.hna.hi.common.fragment.GenderDialogFragment$IGender
-dontnote com.hna.hi.common.fragment.PayDialogFragment$IPay
-dontnote com.hna.hi.common.fragment.IMoreDialogFragment$IMore
-dontnote com.hna.hi.http.response.DeviceStartPageModel$CommonStartPage
-dontnote com.hna.hi.common.fragment.CancelDialogFragment$ICancel
-dontnote com.hna.hi.common.fragment.LongPressDialogFragment$ICallBack
-dontnote com.hna.hi.common.tabstrip.SmartTabLayout$TabColorizer
-dontnote com.hna.hi.common.tabstrip.SmartTabLayout$OnScrollChangeListener
-dontnote com.hna.hi.common.tabstrip.SmartTabLayout$OnTabClickListener
-dontnote com.hna.hi.common.tabstrip.SmartTabLayout$TabProvider
-dontnote com.hna.hi.common.view.ClearEditText$OnEditChange
-dontnote com.hna.hi.common.view.Switch$OnCheckedChangeListener
-dontnote com.hna.hi.common.view.TagGroup$OnTagChangeListener
-dontnote com.hna.hi.view.home.view.navigation.Navigation$OnTabNotSelectedListener
-dontnote com.hna.hi.common.fragment.MoreDialogFragment$IMore
-dontnote com.hna.hi.common.view.TagGroup$OnTagClickListener
-dontnote com.hna.hi.view.home.view.navigation.Navigation$OnTabSelectedListener
-dontnote com.hna.hi.hnahelper.modules.thirdpart.media.view.PlaybackControlView$VisibilityListener
-dontnote com.hna.hi.hnahelper.modules.thirdpart.media.view.PlaybackControlView$ControlDispatcher
-dontnote com.hna.hi.common.view.layout.ExpandableLayout$OnExpansionUpdateListener
-dontnote com.hna.hi.hnahelper.modules.thirdpart.video.view.TimeBar$OnScrubListener
-dontnote com.hna.hi.hnahelper.modules.thirdpart.video.core.VideoRecyclerView
-dontnote com.hna.hi.hnahelper.modules.thirdpart.video.core.PlayerSelector
-dontnote com.hna.hi.hnahelper.modules.thirdpart.video.core.PlayerStateManager
-dontnote com.hna.hi.hnahelper.modules.thirdpart.video.core.SkyPlayer
-dontnote com.google.android.exoplayer2.ui.DefaultTimeBar
-dontnote com.hna.hi.hnahelper.modules.thirdpart.media.view.DefaultTimeBar