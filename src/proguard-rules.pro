# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.yash.shadowlayoyt.customshadow.Customshadow {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/yash/shadowlayoyt/customshadow/repack'
-flattenpackagehierarchy
-dontpreverify
