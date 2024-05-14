package com.cba;

import com.cba.entities.Admin;
import com.cba.repository.repositoryImpl.IAdminRepositoryImpl;
import com.cba.services.IAdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAdmin {
    @InjectMocks
    private IAdminServiceImpl service;
    @Mock
    private IAdminRepositoryImpl Dao;

    @Test
    public void updateDriver() {
        Admin admin1 = new Admin();
        admin1.setAdminId(1);
        admin1.setMobileNumber(953515247L);
        admin1.setUsername("Manish");
        Mockito.when(Dao.updateAdmin(admin1)).thenReturn(admin1);
    }

    @Test
    public void deleteAdmin() {
        Admin admin1 = new Admin();
        admin1.setAdminId(1);
        Mockito.when(Dao.deleteAdmin(12)).thenReturn(admin1);
    }
}
