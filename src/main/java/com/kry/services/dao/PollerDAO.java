package com.kry.services.dao;

import com.kry.services.model.PollerModel;

import java.util.List;

public interface PollerDAO {

    void createServices(PollerModel pollerModel);

    List<PollerModel> getServices();

    void delete(int id);
}
