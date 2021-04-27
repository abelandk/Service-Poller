package com.kry.services.service;

import com.kry.services.dao.PollerDAO;
import com.kry.services.model.PollerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PollerServiceImpl implements PollerService {

    @Autowired
    PollerDAO pollerDAO;

    @Override
    @Transactional
    public void createServices(PollerModel pollerModel) {

        pollerDAO.createServices(pollerModel);
    }


    @Override
    @Transactional
    public List<PollerModel> getServices() {

        return pollerDAO.getServices();
    }

    @Override
    public void delete(int id) {
        pollerDAO.delete(id);
    }
}
