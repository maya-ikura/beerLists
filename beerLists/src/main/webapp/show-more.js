document.addEventListener("DOMContentLoaded", function() {
    const cards = document.querySelectorAll('.beer-card');
    const showMoreButton = document.getElementById('show-more-button');
    
    // 初期表示では10枚目以降のカードを非表示にする
    const visibleCardsCount = 9; // 初期表示するカードの数

    if (cards.length > visibleCardsCount) {
        // 最初の4枚のカード以外に「hidden」クラスを追加
        for (let i = visibleCardsCount; i < cards.length; i++) {
            cards[i].classList.add('hidden');
        }
        showMoreButton.style.display = 'block'; // 「もっと見る」ボタンを表示

        showMoreButton.addEventListener('click', function() {
            // 「もっと見る」ボタンをクリックしたときに全てのカードを表示
            cards.forEach(card => card.classList.remove('hidden'));
            showMoreButton.style.display = 'none'; // ボタンを非表示
        });
    }
});
