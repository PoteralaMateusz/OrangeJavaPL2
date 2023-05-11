package pl.sda.OrangeJavaPL2Spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.entity.BreadType;
import pl.sda.OrangeJavaPL2Spring.repository.BreadRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BreadServiceTest {

    @Mock
    BreadRepository breadRepository;

    @InjectMocks
    BreadService breadService;

    @Test
    void getAllBreads() {
        //given
        Bread bread1 = new Bread(1,"Chleb1", BreadType.WHEAT, BigDecimal.TEN);
        Bread bread2 = new Bread(2,"Chleb2", BreadType.WHEAT, BigDecimal.ONE);
        //when
        Mockito.when(breadRepository.getAllBreads()).thenReturn(List.of(bread1,bread2));
        //then
        assertEquals(breadService.getAllBreads().getBody(),List.of(bread1,bread2));
        assertEquals(breadService.getAllBreads().getStatusCode(), HttpStatus.valueOf(200));
    }
}