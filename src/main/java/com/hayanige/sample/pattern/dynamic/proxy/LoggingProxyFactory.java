package com.hayanige.sample.pattern.dynamic.proxy;

import java.lang.reflect.Proxy;

public class LoggingProxyFactory {
  public static<T> T getProxy(Class<T> intf, final T obj) {
    return (T) Proxy.newProxyInstance(
      obj.getClass().getClassLoader(),
      new Class[] { intf },
      new LoggingInvocationHandler<T>(obj)
    );
  }
}
