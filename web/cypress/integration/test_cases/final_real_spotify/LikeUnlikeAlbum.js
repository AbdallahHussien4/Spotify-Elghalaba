// Auto Complite 
/// <reference types="Cypress" />  


describe('Test Liking Albums',()=>{

    beforeEach(()=>{    
        
        cy.viewport("macbook-15");          //To Change the default view(Tablet) to desktop
        cy.visit('https://accounts.spotify.com/en/login?continue=https:%2F%2Fopen.spotify.com%2F');  //To Open the site
        cy.get('#login-username').type("test54321er@gmail.com"); // Email
        cy.get('#login-password').type("TESTtest123");
        cy.get('#login-button').click();  //click login
        
    });       

    it('Like an album',()=>{

        cy.get('[href="/search"]').click();
        cy.get('._2f8ed265fb69fb70c0c9afef329ae0b6-scss').type("Ya Ahl El Arab Wel Tarab");   //Search Tab
        cy.wait(2000);
        cy.get('.f79dd23c27c3352da3ac3ba62d78f8ea-scss').first().click();           //Album Icon
        cy.wait(2000);
        cy.get('.spoticon-heart-32').click({force: true});      //Like Button
        cy.get('[aria-label="Your Library"]').click();
        cy.get('[href="/collection/albums"]').click();
        cy.get('._80c2c1f0f44b53866fc1b5e9fa66b949-scss').should('contain','Ya Ahl El Arab Wel Tarab');   //Album Card in your library
    });

    it('Unlike an album',()=>{

        cy.get('[aria-label="Your Library"]').click();
        cy.get('[href="/collection/albums"]').click();
        cy.get('._80c2c1f0f44b53866fc1b5e9fa66b949-scss').contains('Ya Ahl El Arab Wel Tarab').click();   //Album Card in your library
        cy.wait(2000);
        cy.get('.spoticon-heart-active-32').click({force: true});       //Like Button
        cy.get('[aria-label="Your Library"]').click();
        cy.get('[href="/collection/albums"]').click();
        cy.get('._80c2c1f0f44b53866fc1b5e9fa66b949-scss').should('not.contain','Ya Ahl El Arab Wel Tarab');     //Dicover Albums
    });
})

