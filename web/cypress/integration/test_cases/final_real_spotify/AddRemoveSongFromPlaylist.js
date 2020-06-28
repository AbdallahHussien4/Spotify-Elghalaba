// Auto Complite 
/// <reference types="Cypress" />  


describe('Test Adding(and Removing) songs to playlists',()=>{

    beforeEach(()=>{    
        
        cy.viewport("macbook-15");          //To Change the default view(Tablet) to desktop
        cy.visit('https://accounts.spotify.com/en/login?continue=https:%2F%2Fopen.spotify.com%2F');  //To Open the site
        cy.get('#login-username').type("test54321er@gmail.com"); // Email
        cy.get('#login-password').type("TESTtest123");
        cy.get('#login-button').click();  //click login
        
    });       

    it('Add song to new playlist',()=>{

        cy.get('[href="/search"]').click();
        cy.get('._2f8ed265fb69fb70c0c9afef329ae0b6-scss').type("mohamed mounir");   //Search Tab
        cy.wait(2000);
        cy.get('.f79dd23c27c3352da3ac3ba62d78f8ea-scss').first().click();           //Song Icon
        cy.wait(2000);
        cy.get('.tracklist-name').first().then((x)=>{
            cy.get('.tracklist-name').first().rightclick();
            cy.get('.react-contextmenu-item').eq('3').click();
            cy.wait(2000);
            cy.get('._2221af4e93029bedeab751d04fab4b8b-scss').contains('NEW PLAYLIST').click();
            cy.get('.inputBox-input').type('Testing');
            cy.get('._2221af4e93029bedeab751d04fab4b8b-scss').contains('CREATE').click();
            cy.wait(2000);
            cy.get('[aria-label="Your Library"]').click();
            cy.get('._80c2c1f0f44b53866fc1b5e9fa66b949-scss').contains('Testing').click();
            cy.wait(2000);
            cy.get('.tracklist-name').first().then((y)=>{
                expect(x.text()).to.equal(y.text());
            })
        })
    });

    it('Remove Song From Playlist',()=>{

        cy.get('[aria-label="Your Library"]').click();
        cy.get('._80c2c1f0f44b53866fc1b5e9fa66b949-scss').contains('Testing').click();
        cy.wait(2000);
        cy.get('.tracklist-name').first().rightclick();
        cy.get('.react-contextmenu-item').eq('4').click();
        cy.get('._8e9a0858c7c9d25c9b7193cd3acb12cf-scss').should('contain',"It's a bit empty here...");
    
    });
    it.only('Add song to old playlist',()=>{

        cy.get('[href="/search"]').click();
        cy.get('._2f8ed265fb69fb70c0c9afef329ae0b6-scss').type("mohamed mounir");   //Search Tab
        cy.wait(2000);
        cy.get('.f79dd23c27c3352da3ac3ba62d78f8ea-scss').first().click();           //Song Icon
        cy.wait(2000);
        cy.get('.tracklist-name').first().then((x)=>{
            cy.get('.tracklist-name').first().rightclick();
            cy.get('.react-contextmenu-item').eq('3').click();
            cy.wait(2000);
            cy.get('.mo-coverArt-hoverContainer').first().click();
            cy.wait(2000);
            cy.get('[aria-label="Your Library"]').click();
            cy.get('._80c2c1f0f44b53866fc1b5e9fa66b949-scss').contains('Testing').click();
            cy.wait(2000);
            cy.get('.tracklist-name').first().then((y)=>{
                expect(x.text()).to.equal(y.text());
            })
        })

    })
})

