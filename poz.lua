IsRun = true;



function main()
   while IsRun do
   dofile("pozremake.lua")
      message("Скрипт запущен")
   sleep(2000);
   end;
end;

function OnStop()
   IsRun = false;
   message("Скрипт остановлен")
end;







