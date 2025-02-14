package calendario;

public class Data implements Cloneable, Comparable <Data>
{
    private byte dia, mes;
    private short ano;
    
    private static boolean isBissexto (short ano)
    {
        // Calendario Juliano
        if (ano<1582)
            if (ano%4==0)
                return true;
            else
                return false;

        // Calendario Gregoriano
        if (ano%400==0) return true;
        if (ano%  4==0 && ano%100!=0) return true;
        return false;
    }
    
    private static boolean isValida (byte dia, byte mes, short ano)
    {
        if (ano<-45) return false; // antes do Calendario Juliano
        if (ano== 0) return false; // nao existiu ano 0; do ano 1ac foi direto para o ano 1dc
        if (ano==1582 && mes==10 && dia>=5 && dia<=14) return false; // dias cortados dos calendario pelo Papa Gregorio

        if (dia<1 || dia>31 || mes<1 || mes>12) return false;

        if (dia>30 && (mes==4 || mes==6 || mes==9 || mes==11)) return false;
        if (dia>29 && mes==2) return false;
        if (dia>28 && mes==2 && !Data.isBissexto(ano)) return false;

        return true;
    }

    public Data (byte dia, byte mes, short ano) throws Exception
    {
        if (!Data.isValida(dia,mes,ano))
            throw new Exception ("Data invalida");

        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }

    public void setDia (byte dia) throws Exception
    {
        if (!Data.isValida(dia,this.mes,this.ano))
            throw new Exception ("Dia invalido");
            
        this.dia=dia;
    }    
    
    public void setMes (byte mes) throws Exception
    {
        if (!Data.isValida(this.dia,mes,this.ano))
            throw new Exception ("Mes invalido");
            
        this.mes=mes;
    }
    
    public void setAno (short ano) throws Exception
    {
        if (!Data.isValida(this.dia,this.mes,ano))
            throw new Exception ("Ano invalido");
            
        this.ano=ano;
    }
    
    public byte getDia ()
    {
        return this.dia;
    }
    
    public byte getMes ()
    {
        return this.mes;
    }
    
    public short getAno ()
    {
        return this.ano;
    }
    
    public void avanceUmDia ()
    {
        if (this.dia==4 && this.mes==10 && this.ano==1582)
            this.dia=(byte)15;
        else if (this.dia==31 && this.mes==12 && this.ano==-1)
        {
			this.dia=(byte) 1;
			this.mes=(byte) 1;
			this.ano=(short)1;
		}
		else if (Data.isValida((byte)(this.dia+1),this.mes,this.ano))
		    this.dia++;
		else if (Data.isValida((byte)1,(byte)(this.mes+1),this.ano))
		{
			this.dia=(byte)1;
			this.mes++;
		}
		else // if (Data.isValida((byte)1,(byte)1,(short)(this.ano+1)))
		{
			this.dia=(byte)1;
			this.mes=(byte)1;
			this.ano++;
		}
    }

    public void avanceVariosDias (int qtd) throws Exception
    {
        if (qtd <= 0) throw new Exception("ERRO! Por favor, Digite valores acima de 0!");
        for (int i=0;i<qtd;i++) this.avanceUmDia();
    }

    public void retrocedaUmDia () 
    {
        if (this.dia==1 && this.mes==1 && this.ano==1)
        {
			this.ano=(short)-1;
            this.mes=(byte)12;
            this.dia=(byte)31;
		}
        else if (this.ano==1582 && this.mes==10 && this.dia==15)
            this.dia=(byte)4;
        else if (Data.isValida((byte)(this.dia-1),this.mes,this.ano))
            this.dia--;
		else if (Data.isValida((byte)31,(byte)(this.mes-1),this.ano))
		{
            this.dia=(byte)31;
            this.mes--;
        }
        else if (Data.isValida((byte)30,(byte)(this.mes-1),this.ano))
        {
            this.dia=(byte)30;
            this.mes--;
        }
        else if (Data.isValida((byte)29,(byte)(this.mes-1),this.ano))
        {
            this.dia=(byte)29;
            this.mes--;
        }
        else if (Data.isValida((byte)28,(byte)(this.mes-1),this.ano))
        {
            this.dia=(byte)28;
            this.mes--;
        }
        else 
        {
            this.dia=(byte)31;
            this.mes=(byte)12;
            this.ano--;
        }
    }

    public void retrocedaVariosDias (int qtd) throws Exception 
    {
        if (qtd <= 0) throw new Exception("ERRO! Por favor, Digite valores acima de 0!");
        for(int i=0; i<qtd; i++) this.retrocedaUmDia();
    }   

    public Data getDiaSeguinte() 
    {
        Data ret=null;
        try
        {
            ret = new Data(this.dia,this.mes,this.ano);
        } catch (Exception erro) 
        {}

        ret.avanceUmDia();
        return ret;
    }

    public Data getVariosDiasAdiante (int qtd) throws Exception 
    {
        if (qtd<=0) throw new Exception("ERRO! Por favor, Digite valores acima de 0!");

        Data ret=null;
        try {
            ret = new Data(this.dia, this.mes, this.ano);
        } catch (Exception erro)
        {}

        ret.avanceVariosDias(qtd);
        return ret;
    }

    public Data getDiaAnterior () 
    {
        Data ret=null;
        try
        {
            ret = new Data(this.dia,this.mes,this.ano);
        } catch (Exception erro)
        {}

        ret.retrocedaUmDia();
        return ret;
    }

    public Data getVariosDiasAtras (int qtd) throws Exception 
    {
        if (qtd<=0)
            throw new Exception("ERRO! Por favor, Digite valores acima de 0!");

        Data ret = null;
        try
        {
            ret = new Data(this.dia,this.mes,this.ano);
        } catch (Exception erro)
        {}
        
        ret.retrocedaVariosDias(qtd);
        return ret;
    }

    @Override
    public String toString() {
        return String.format("Hoje é %d/%d/%d", this.dia, this.mes, this.ano);
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj==this) return true;
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;
        
        Data d = (Data)obj;
        if (d.dia!=this.dia) return false;
        if (d.mes!=this.mes) return false;
        if (d.ano!=this.ano) return false;

        return true;
    }
    
    public int hashCode ()
    {
        int ret=1; 
        
        ret = ret *  2 + Byte.valueOf(this.dia).hashCode();
        ret = ret * 11 + Byte.valueOf(this.mes).hashCode(); 
        ret = ret *  2 + Short.valueOf(this.ano).hashCode();

        if (ret<0) ret=-ret;
        return ret;
	}

    @Override
    public int compareTo (Data d)
    {
        if (this.ano<d.ano) return -1;
        if (this.ano>d.ano) return 1;

        if (this.mes<d.mes) return -1;
        if (this.mes>d.mes) return 1;

        if (this.dia<d.dia) return -1;
        if (this.dia>d.dia) return 1;

        return 0;
    }

    public Data(Data modelo) throws Exception
    {
        if (modelo==null) throw new Exception("Modelo ausente");

        this.dia=modelo.dia;
        this.mes=modelo.mes;
        this.ano=modelo.ano;
    }

    @Override
    public Data clone()
    {
        Data d=null;
        try
        {
            d = new Data(this);
        } catch (Exception error)
        {}

        return d;
    }
}

