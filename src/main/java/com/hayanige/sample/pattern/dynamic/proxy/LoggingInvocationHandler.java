package com.hayanige.sample.pattern.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInvocationHandler<T> implements InvocationHandler {
  final T underlying;
  
  public LoggingInvocationHandler(T underlying) {
    this.underlying = underlying;
  }
  
  public Object invoke(Object proxy, Method method, Object[] args)
          throws Throwable {
      StringBuffer sb = new StringBuffer();
      sb.append(method.getName());
      sb.append("(");
      for (int i = 0; args != null && i < args.length; i++) {
        if (i != 0) {
          sb.append(", ");
        }
        sb.append(args[i]);
      }
      sb.append(")");
      Object ret = method.invoke(underlying, args);
      if (ret != null) {
        sb.append(" -> ");
        sb.append(ret);
      }
      System.out.println(sb);
      return ret;
  }
}
