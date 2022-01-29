$.when( $.ready ).then(() => {
    $('#customer-update-button').click( event => {
        event.preventDefault()
        console.log('Clicked!')
    })
})