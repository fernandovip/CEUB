async function addToGoogleSheet(auth, purchaseData) {
    console.log('Iniciando adição à planilha...');
    const planilhaID = '1VSrnmOpaNRvIa_jniQpbCHRm5M8IDTUZSaVDRhBsFAE';
    const colunas = 'Controle de Compras na Internet!A';

    try {
        const response = await fetch(`https://sheets.googleapis.com/v4/spreadsheets/${planilhaID}/values/${colunas}:append?valueInputOption=RAW`, {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${auth}`,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                values: [
                    [purchaseData.date, purchaseData.amount, purchaseData.store]
                ]
            })
        });

        console.log('Resposta da API:', response);

        if (!response.ok) {
            throw new Error(`Erro ao adicionar dados na planilha: ${response.statusText}`);
        }
        console.log('Compra adicionada à planilha com sucesso');
    } catch (error) {
        console.error('Erro ao adicionar à planilha:', error);
    }
}

function getGoogleAuthToken() {
    return new Promise((resolve, reject) => {
        chrome.identity.getAuthToken({ interactive: true }, (token) => {
            if (chrome.runtime.lastError || !token) {
                console.error('Erro ao obter token:', chrome.runtime.lastError);
                reject(chrome.runtime.lastError);
                return;
            }
            console.log('Token OAuth2 obtido:', token);
            resolve(token);
        });
    });
}

chrome.runtime.onMessage.addListener((request, sender, sendResponse) => {
    console.log('Mensagem recebida:', request);
    if (request.action === 'savePurchase') {
        getGoogleAuthToken().then(token => {
            addToGoogleSheet(token, request.purchaseData);
            sendResponse({ status: 'success' });
        }).catch(error => {
            console.error('Erro ao autenticar', error);
            sendResponse({ status: 'error' });
        });
        return true; // Indica que a resposta será enviada
    }
});
