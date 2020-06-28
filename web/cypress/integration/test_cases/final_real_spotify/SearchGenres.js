/// <reference types="Cypress" />


describe('Search_By_Genres' , () => {
    
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

    //Search by Arabic genre
    it('Search by Arabic genre' , () => {                                
        cy.contains('Search').click();
        cy.contains('Arabic').click();
    })

    //Search by Hip-hop genre
    it('Search by Hip-hop genre' , () => {                                
        cy.contains('Search').click();
        cy.contains('Hip-Hop').click();
    })

    
    //Search by Podcasts genre
    it('Search by Arabic genre' , () => {                                
        cy.contains('Search').click();
        cy.contains('Podcasts').click();
    })
})