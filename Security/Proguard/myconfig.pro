-injars C:\Core\TestWorkspace\Prograud\input\obfuscator.jar
-outjars C:\Core\TestWorkspace\Prograud\
-libraryjars C:\Program Files\Java\jre1.8.0_131\lib\rt.jar

-keepclasseswithmembers class ** {
    public java.lang.String computeKey_Hash (java.lang.String , java.lang.Object[] );
}
-dontshrink
-obfuscationdictionary C:\Development_Avecto\proguard5.3.3\ObscateString\obs.txt
-classobfuscationdictionary C:\Development_Avecto\proguard5.3.3\ObscateString\obs.txt
-packageobfuscationdictionary C:\Development_Avecto\proguard5.3.3\ObscateString\obs.txt
-dontoptimize
-ignorewarnings