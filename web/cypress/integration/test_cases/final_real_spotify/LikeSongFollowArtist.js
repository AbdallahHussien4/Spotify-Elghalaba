/// <reference types="Cypress" />


describe('Like_Song-Follow_Artist' , () => {
    
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

    //follow an artist 
    it('follow an artist' , () => { 
        cy.contains('Search').click();
        cy.get('[class="_2f8ed265fb69fb70c0c9afef329ae0b6-scss"]').click().type('hamza namira');       
        cy.get('[class="f79dd23c27c3352da3ac3ba62d78f8ea-scss"]').eq(0).click();
        cy.wait(4000);
        cy.contains('follow').click();
        cy.contains('Your Library').click();
        cy.wait(1000);
        cy.contains('More').click();
        cy.contains('Artists').click();
    })

    //Like a song 
    it('Like a Song' , () => { 
        cy.contains('Search').click();
        cy.get('[class="_2f8ed265fb69fb70c0c9afef329ae0b6-scss"]').click().type('kefak enta');       
        cy.get('[class="f79dd23c27c3352da3ac3ba62d78f8ea-scss"]').eq(0).click();
        cy.wait(4000);
        cy.get('[class="spoticon-heart-32"]').click();
        cy.contains('Liked Songs').click();
        cy.wait(1000);
    })
    
    
})