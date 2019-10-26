using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace net_pagopension
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {
            double pension = 250.00;
            int hijos = int.Parse((nudHijos.Value).ToString());

            if (hijos==1)
            {
                txtTotal.Text = "250.00";
            }else if (hijos == 2)
            {
                txtTotal.Text = "400.00";
            }else if (hijos > 2)
            {
                var total = pension * hijos*0.7;
                txtTotal.Text = total.ToString("0.00");
            }

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            txtTotal.Text = "250.00";
        }
    }
}
