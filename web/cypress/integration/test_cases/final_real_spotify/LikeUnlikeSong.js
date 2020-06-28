// Auto Complite 
/// <reference types="Cypress" />  


describe('Test Liking the songs',()=>{

    beforeEach(()=>{    
        
        cy.viewport("macbook-15");          //To Change the default view(Tablet) to desktop
        cy.visit('https://accounts.spotify.com/en/login?continue=https:%2F%2Fopen.spotify.com%2F',{ timeout: 10000 });  //To Open the site
        cy.get('#login-username').type("test54321er@gmail.com"); // Email
        cy.get('#login-password').type("TESTtest123");
        cy.get('#login-button').click();  //click login
        
    });       


    it('Like a Song',()=>{

        cy.get('[href="/search"]').click();
        cy.get('._2f8ed265fb69fb70c0c9afef329ae0b6-scss').type("mahmoum");   //Search Tab
        cy.wait(3000);
        cy.get('.f79dd23c27c3352da3ac3ba62d78f8ea-scss').first().click();    //Song Icon
        cy.wait(3000);
        cy.get('.spoticon-heart-16').first().click();      //Heart Button
        cy.wait(2000);
        cy.get('[href="/collection/tracks"]').click();
        cy.get('.tracklist-name').should('contain','Mahmoum');   //Song bar in your library
     
    });

    it('Unlike a song',()=>{

        cy.contains('Search').click();
        cy.get('._2f8ed265fb69fb70c0c9afef329ae0b6-scss').type("mahmoum");   //Search Tab
        cy.wait(4000);
        cy.get('.f79dd23c27c3352da3ac3ba62d78f8ea-scss').first().click();    //Song Icon
        cy.wait(4000);
        cy.get('.spoticon-heart-active-16').eq(1).click();      //Heart Button
        cy.wait(2000);
        cy.get('[href="/collection/tracks"]').click();
        cy.get('.tracklist-name').should('not.contain','Mahmoum');   //song Card in your library    });
})
})

