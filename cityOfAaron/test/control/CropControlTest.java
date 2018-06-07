/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.CropData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author brucem
 */
public class CropControlTest {
    CropData theCrops = new CropData();
    
    public CropControlTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   /**
     * Test of sellLand method, of class CropControl.
     */
    @Test
    public void testSellLand() {
        System.out.println("sellLand");
        
        //--- Test case 1 ---
        System.out.println("\tTest case 1");
        theCrops.setwheatInStore(1000);
        theCrops.setacresOwned(2800);
        int landPrice = 15;
        int acresToSell = 10;
        int expResult = 2790;
        int result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
    
        //--- Test case 2 ---
        System.out.println("\tTest case 2");
        theCrops.setwheatInStore(1000);
        theCrops.setacresOwned(2800);
        landPrice = 20;
        acresToSell = -5;
        expResult = -1;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        //--- Test case 3 ---
        System.out.println("\tTest case 3");
        theCrops.setwheatInStore(1000);
        theCrops.setacresOwned(2800);
        landPrice = 20;
        acresToSell = 3000;
        expResult = -1;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        //--- Test case 4 ---
        System.out.println("\tTest case 4");
        theCrops.setwheatInStore(1000);
        theCrops.setacresOwned(2000);
        landPrice = 10;
        acresToSell = 2000;
        expResult = 0;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        //--- Test case 5 ---
        System.out.println("\tTest case 5");
        theCrops.setwheatInStore(1000);
        theCrops.setacresOwned(2000);
        landPrice = 10;
        acresToSell = 0;
        expResult = 2000;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
    }

    /**
     * Test of buyLand method, of class CropControl.
     */
    @Test
    public void testBuyLand() {
        System.out.println("buyLand");
        
         //--- Test case 1 ---
        System.out.println("\tTest case 1");
        theCrops.setwheatInStore(2700);
        theCrops.setacresOwned(2000);
        theCrops.setpopulation(205);
        int landPrice =20;
        int acresToBuy = 10;
        int expResult = 2010;
        int result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 2 ---
        System.out.println("\tTest case 2");
        theCrops.setwheatInStore(2700);
        theCrops.setacresOwned(2000);
        theCrops.setpopulation(205);
        landPrice =20;
        acresToBuy = -1;
        expResult = -1;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 3 ---
        System.out.println("\tTest case 3");
        theCrops.setwheatInStore(2700);
        theCrops.setacresOwned(2000);
        theCrops.setpopulation(205);
        landPrice =20;
        acresToBuy = 150;
        expResult = -1;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 4 ---
        System.out.println("\tTest case 4");
        theCrops.setwheatInStore(2700);
        theCrops.setacresOwned(2000);
        theCrops.setpopulation(205);
        landPrice =20;
        acresToBuy = 60;
        expResult = -1;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 5 ---
        System.out.println("\tTest case 5");
        theCrops.setwheatInStore(2700);
        theCrops.setacresOwned(2000);
        theCrops.setpopulation(205);
        landPrice =20;
        acresToBuy = 0;
        expResult = 2000;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 6 ---
        System.out.println("\tTest case 6");
        theCrops.setwheatInStore(2700);
        theCrops.setacresOwned(2000);
        theCrops.setpopulation(211);
        landPrice =25;
        acresToBuy = 108;
        expResult = 2108;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 7 ---
        System.out.println("\tTest case 7");
        theCrops.setwheatInStore(2800);
        theCrops.setacresOwned(2000);
        theCrops.setpopulation(211);
        landPrice =25;
        acresToBuy = 110;
        expResult = 2110;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
    }

    /**
     * Test of plantCrops method, of class CropControl.
     */
    @Test
    public void testPlantCrops() {
        System.out.println("plantCrops");
        
         //--- Test case 1 ---
        System.out.println("\tTest case 1");
        theCrops.setwheatInStore(2450);
        theCrops.setacresOwned(1000);
        int acresToPlant = 500;
        int expResult = 500;
        int result = CropControl.plantCrops(acresToPlant, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 2 ---
        System.out.println("\tTest case 2");
        theCrops.setwheatInStore(2700);
        theCrops.setacresOwned(1000);
        acresToPlant = -1;
        expResult = -1;
        result = CropControl.plantCrops(acresToPlant, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 3 ---
        System.out.println("\tTest case 3");
        theCrops.setwheatInStore(2700);
        theCrops.setacresOwned(1000);
        acresToPlant = 1002;
        expResult = -1;
        result = CropControl.plantCrops(acresToPlant, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 4 ---
        System.out.println("\tTest case 4");
        theCrops.setwheatInStore(250);
        theCrops.setacresOwned(1000);
        acresToPlant = 600;
        expResult = -1;
        result = CropControl.plantCrops(acresToPlant, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 5 ---
        System.out.println("\tTest case 5");
        theCrops.setwheatInStore(2700);
        theCrops.setacresOwned(1000);
        acresToPlant = 0;
        expResult = 0;
        result = CropControl.plantCrops(acresToPlant, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 6 ---
        System.out.println("\tTest case 6");
        theCrops.setwheatInStore(2200);
        theCrops.setacresOwned(1000);
        acresToPlant = 1000;
        expResult = 1000;
        result = CropControl.plantCrops(acresToPlant, theCrops);
        assertEquals(expResult, result);
        
         //--- Test case 7 ---
        System.out.println("\tTest case 7");
        theCrops.setwheatInStore(250);
        theCrops.setacresOwned(1000);
        acresToPlant = 500;
        expResult = 500;
        result = CropControl.plantCrops(acresToPlant, theCrops);
        assertEquals(expResult, result);
    }

    /**
     * Test of feedPeople method, of class CropControl.
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople");
        int wheatForPeople = 0;
        
        CropControl instance = new CropControl();
        int expResult = 0;
        int result = instance.feedPeople(wheatForPeople, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

   

    /**
     * Test of checkOffering method, of class CropControl.
     */
    @Test
    public void testCheckOffering() {
        System.out.println("checkOffering");
        int tithe = 0;
        CropData cropData = new CropData();
        CropControl.checkOffering(tithe, cropData);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
