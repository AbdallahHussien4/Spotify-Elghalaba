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

    it('Play Playlist Sequintially',()=>{

        cy.get('[href="/search"]').click();
        cy.get('._2f8ed265fb69fb70c0c9afef329ae0b6-scss').type("this is mohamed mounir");   //Search Tab
        cy.wait(2000);
        cy.get('.f79dd23c27c3352da3ac3ba62d78f8ea-scss').first().click();           //Playlist Icon
        cy.wait(2000);
        cy.get('._11f5fc88e3dec7bfec55f7f49d581d78-scss').last().click({force: true});      //Play Button
        cy.wait(2000);

        cy.get('.tracklist-name').first().then((x)=>{                               //First Song 
            cy.get('[data-testid="nowplaying-track-link"]').first().then((y)=>{     //now playing Song 
                expect(x.text()).to.equal(y.text());
            })
        })
        cy.get('[data-testid="control-button-skip-forward"]').first().click();      //next button
        cy.wait(2000);

        cy.get('.tracklist-name').eq(1).then((x)=>{                                 //second song
            cy.get('[data-testid="nowplaying-track-link"]').first().then((y)=>{     
                expect(x.text()).to.equal(y.text());
            })
        })

        cy.get('[data-testid="control-button-skip-forward"]').first().click();
        cy.wait(2000);

        cy.get('.tracklist-name').eq(2).then((x)=>{
            cy.get('[data-testid="nowplaying-track-link"]').first().then((y)=>{
                expect(x.text()).to.equal(y.text());
            })
        })
       
    });

})

