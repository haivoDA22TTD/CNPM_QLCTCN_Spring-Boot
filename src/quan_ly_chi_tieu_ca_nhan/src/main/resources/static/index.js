
        // JavaScript để ẩn thông báo sau 5 giây
        document.addEventListener('DOMContentLoaded', function() {
            const logoutMessage = document.getElementById('logout-message');
            if (logoutMessage) {
                setTimeout(() => {
                    logoutMessage.classList.add('hidden'); // Ẩn thông báo
                }, 5000); // 5 giây
            }
        });
