/// <reference types="Cypress" />


describe('Search_for_Song' , () => {
    
    beforeEach(()=>{                                             // Before each test
        cy.viewport("macbook-15");                               // @bout View
        cy.visit('https://open.spotify.com/',{ timeout: 10000 }); // Original Spotify
        cy.contains('Log in').click();                           // Log in
        cy.get('#login-username').type("test54321er@gmail.com"); // Email
        cy.get('#login-password').type("TESTtest123");           // Password
        cy.contains('Log In').click();                           // Login
        cy.wait(6000);
    });

    afterEach(()=>{                                                         // After each test
         cy.get('[class="_34098cfd13d48e2910679f35aea2c377-scss"]').click();// Log out
         cy.contains('Log out').click();
    });

    
    //Search for song1
    it('Search for song1 = Result' , () => {                                // with selection of search-bar
        cy.contains('Search').click();
        cy.get('[class="_2f8ed265fb69fb70c0c9afef329ae0b6-scss"]').click().type('kefak enta');       
    })

    //Search for song2
    it('Search for song2 = No Result' , () => {                             // without selection of search-bar
        cy.contains('Search').click();
        cy.get('[class="_2f8ed265fb69fb70c0c9afef329ae0b6-scss"]').type('kefek enta');       
    })

})