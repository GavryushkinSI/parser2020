IsRun = true;



function main()
   while IsRun do
   dofile("pozremake.lua")
      message("������ �������")
   sleep(2000);
   end;
end;

function OnStop()
   IsRun = false;
   message("������ ����������")
end;







