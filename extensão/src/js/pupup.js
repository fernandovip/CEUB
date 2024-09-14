document.getElementById('purchaseForm').addEventListener('submit', (e) => {
    e.preventDefault();
    const purchaseAmount = document.getElementById('purchaseAmount').value;
    const purchaseData = {
        amount: purchaseAmount,
        date: new Date().toLocaleDateString(),
        store: 'Loja Exemplo'
    };

    chrome.runtime.sendMessage({ action: 'savePurchase', purchaseData: purchaseData }, (response) => {
        if (response.status === 'success') {
            document.getElementById('status').textContent = 'Compra registrada com sucesso na planilha!';
            document.getElementById('purchaseAmount').value = '';
        } else {
            document.getElementById('status').textContent = 'Erro ao registrar compra na planilha.';
            document.getElementById('status').style.color = 'red';
        }
    });
});
