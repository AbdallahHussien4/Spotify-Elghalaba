/// <reference types="Cypress" />


describe('Sprint #2 Testing' , () => {
    
    beforeEach(()=>{                                        // before each test
        
        cy.viewport("macbook-15");                          // @bout View
        cy.visit('https://spotify-elghalaba.me/');          // spotify-elghalaba
        cy.contains('LOGIN').click();                       // Log in
        cy.get('#emailField').type("test1@test.com");       // Email
        cy.get('#passwordField').type("12345678");          // password
        cy.contains('Log In').click();                      // Login
        
    });       

    
    //test Search buttons
    it('Search Button' , () => {
        cy.contains('Search').click();
        cy.get('#search-bar').click().type('Fairouz');
        cy.get(".v-input__icon--prepend-inner").click();
        cy.get('#search-bar').clear();
        cy.get('#search-bar').click().type('ja');
        cy.get(".v-input__icon--prepend-inner").type('{Enter}');
        cy.wait(5000);
        cy.contains('See All').click();
        cy.contains('Javascript Design Patterns').trigger('mouseover');
        cy.get('.v-btn--round').should('be.visible').eq(2).click();
        cy.get('.v-btn--round').should('be.visible').eq(2).click();
        cy.contains('Javascript Design Patterns').click();
    })
    
    //test Prefered Genres
    it('Prefered Genres' , () => {                      // No Geners yet to be tested
        cy.contains('Search').click();
        cy.contains('Hip-Hop').click();
        cy.go('back');
        cy.contains('Arabic').click();
        cy.go('back');
    })
    
    //test Prefered Genres
    it('Your Library Module Playlist & Albums Components' , () => {
        //library logic
        cy.get('[href="/home/library/playlists"]').click();
        //Albums
        cy.contains(' Albums ').click();
        cy.get('#cardID').click();
        cy.wait(5000);
        cy.get('.v-btn--round').eq(0).click(); //test back button
        cy.contains('Playlists').click();
        cy.wait(5000);


        //Play/Pause button
        cy.get('#cardID').trigger('mouseover');
        cy.get('.v-btn--round').should('be.visible').eq(2).click(); //test play button
        cy.get('.v-btn--round').should('be.visible').eq(2).click(); //test pause button

        //Playlists
        cy.get('#cardID').eq(0).click();
        cy.wait(5000);
        cy.get('.v-responsive__content').eq(2).trigger('mouseover');
        cy.get('.v-overlay__content').should('be.visible').eq(0).click(); //test play hidden button
        cy.get('.v-overlay__content').should('be.visible').eq(0).click(); //test pause hidden button
        cy.contains(' Play ').click();
        cy.contains(' Pause ').click();
        cy.go('back');
        cy.contains('hopa').click();
        cy.get('.v-btn--round').eq(0).click();
    })

    it('Artist Components' , () => {//Artist (No Artist yet to be tested)
    cy.contains('Artists').click();
    cy.get('Afasi & Filthy').rightclick();
    cy.contains('Wegz').rightclick();
    cy.contains('Afasi & Filthy').click();
    cy.get('.v-btn--round').should('be.visible').eq(0).click();
    cy.contains('Wegz').click();
    cy.contains('related Artists').click();
    cy.contains('Wanda Jackson').click();
    cy.get('.v-btn--round').should('be.visible').eq(0).click().click().click();
    })
})