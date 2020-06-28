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

    //Home-Search-Yourlibrary-CreatPlaylist-LikedSongs
    it('Test tool-bar' , () => {                                
        cy.contains('Home');
        cy.contains('Search');
        cy.contains('Your Library');
        cy.contains('Create Playlist');
        cy.contains('Liked Songs');
        cy.contains('andrew');
    })
    it('Test home page' , () => {                                
        cy.get('[class="_19813d13f17b9971773e54f5957ee593-scss"]');
        cy.get('[class="_6be6d9f3103325b95e6d4c0f6b10b783-scss"]').eq(0);
        cy.get('[class="_6be6d9f3103325b95e6d4c0f6b10b783-scss"]').eq(1);
        cy.get('[class="f79dd23c27c3352da3ac3ba62d78f8ea-scss"]').eq(0);
        cy.get('[class="f79dd23c27c3352da3ac3ba62d78f8ea-scss"]').eq(1);
    })
})