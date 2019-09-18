#include <stdio.h>
#include <jni.h>
#include "nativeAllocation.h"

JNIEXPORT jobject JNICALL
Java_generic_NativeAllocation_getObject(JNIEnv *env, jobject obj)
{
  jclass class = (*env)->FindClass(env,"java/lang/Object");
  jmethodID mid = (*env)->GetMethodID(env, class, "<init>", "()V");

  return (*env)->NewObject(env, class, mid);
}

JNIEXPORT jobject JNICALL
Java_generic_NativeAllocation_getNullObject(JNIEnv *env, jobject obj)
{
  return (*env)->NewGlobalRef(env, NULL);
}
