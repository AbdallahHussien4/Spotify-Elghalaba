// Auto Complite 
/// <reference types="Cypress" />  


describe('Test Following the artitsts',()=>{

    beforeEach(()=>{    
        
        cy.viewport("macbook-15");          //To Change the default view(Tablet) to desktop
        cy.visit('https://accounts.spotify.com/en/login?continue=https:%2F%2Fopen.spotify.com%2F',{ timeout: 10000 });  //To Open the site
        cy.get('#login-username').type("test54321er@gmail.com"); // Email
        cy.get('#login-password').type("TESTtest123");
        cy.get('#login-button').click();  //click login
        
    });       

    it('Follow an artist',()=>{

        cy.get('[href="/search"]').click();
        cy.get('._2f8ed265fb69fb70c0c9afef329ae0b6-scss').type("mohamed mounir");   //Search Tab
        cy.wait(2000);
        cy.get('.f79dd23c27c3352da3ac3ba62d78f8ea-scss').first().click();           //Artist Icon
        cy.wait(2000);
        cy.get('.b49b68b14a1771a4cb36313f2b350e84-scss').click({force: true});      //Follow Button
        cy.get('[aria-label="Your Library"]').click();
        cy.get('[href="/collection/artists"]').click();
        cy.get('._80c2c1f0f44b53866fc1b5e9fa66b949-scss').should('contain','Mohamed Mounir');   //Artist Card in your library
    });

    it('UnFollow an artist',()=>{

        cy.get('[aria-label="Your Library"]').click();
        cy.get('[href="/collection/artists"]').click();
        cy.get('._80c2c1f0f44b53866fc1b5e9fa66b949-scss').contains('Mohamed Mounir').click();   //Artist Card in your library
        cy.wait(2000);
        cy.get('.b49b68b14a1771a4cb36313f2b350e84-scss').click({force: true});                  //Follow Button
        cy.get('[aria-label="Your Library"]').click();
        cy.get('[href="/collection/artists"]').click();
        cy.get('._80c2c1f0f44b53866fc1b5e9fa66b949-scss').should('not.contain','Mohamed Mounir');     //Dicover Artists
    });
})

