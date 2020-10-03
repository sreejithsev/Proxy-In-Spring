package com.springmagic.demo.springcache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class PrimeCheckerImpl implements IPrimeChecker {

    private static final BigDecimal ONE = new BigDecimal("1");
    private static final BigDecimal TWO = new BigDecimal("2");
    private static final BigDecimal THREE = new BigDecimal("3");


    @Override
    @Cacheable("prime")
    public Boolean isPrime(int n){

        log.info("Computing isPrime() for number "+n);

        BigDecimal number = new BigDecimal(n);
        if(number.compareTo(ONE) <= 0){
            return false;
        }
        if(number.compareTo(THREE) <= 0){
            return true;
        }
        if(number.remainder(TWO).equals(BigDecimal.ZERO)){
            return false;
        }
        for( BigDecimal divisor = new BigDecimal("3");
             divisor.compareTo(number.divide(TWO))  < 0;
             divisor = divisor.add(TWO) ){
            if(number.remainder(divisor).equals(BigDecimal.ZERO)){
                return false;
            }
        }
        return true;
    }
}
