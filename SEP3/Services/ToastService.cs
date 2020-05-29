using System;
using System.Timers;
using Timer = System.Timers.Timer;

namespace SEP3.Services
{
    public enum ToastLevel
    {
        Info,
        Success,
        Warning,
        Error
    }
    public class ToastService : IDisposable
    {


        public event Action<String, ToastLevel> onShow;
        public event Action OnHide;
        private Timer Countdown;

        public void ShowToast(String message, ToastLevel level)
        {
            onShow?.Invoke(message, level);
            StartCountdown();
        }

        public void StartCountdown()
        {
            SetCountdown();
            if (Countdown.Enabled)
            {
                Countdown.Stop();
                Countdown.Start();
            }
        }

        private void SetCountdown()
        {
            if(Countdown == null)
            {
                Countdown = new Timer(5000);
                Countdown.Elapsed += HideToast;
                Countdown.AutoReset = false;
            }
        }

        private void HideToast(Object source, ElapsedEventArgs args)
        {
            OnHide?.Invoke();
        }
        public void Dispose()
        {
            Countdown.Dispose();
        }
    }
}
