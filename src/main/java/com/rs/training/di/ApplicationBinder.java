package com.rs.training.di;

import com.rs.training.dao.TestDao;
import com.rs.training.endpoints.HelloWorldEndPoint;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class ApplicationBinder extends AbstractBinder {

  @Override
  protected void configure() {
    bind(HelloWorldEndPoint.class).to(HelloWorldEndPoint.class);
    bind(TestDao.class).to(TestDao.class);
  }
}
